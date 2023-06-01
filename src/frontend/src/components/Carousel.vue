<template>
  <div class="carousel-container">
    <!-- Slideshow container -->
    <div class="slideshow-container">
      <div v-for="(image, index) in images" class="mySlides fade" :class="{ shown: image.isShown }">
        <div class="numbertext">{{index + 1}} / {{this.images.length}}</div>
        <img style="width: 100%; height: auto;" :src="require(`../assets/img/carousel/${image.title}`)" alt="{{ image.title }}">
        <div class="text">{{image.desc}}</div>
      </div>

      <!-- Next and previous buttons -->
      <a class="prev" @click="slideBackward()">&#10094;</a>
      <a class="next" @click="slideForward()">&#10095;</a>
    </div>

    <!-- The dots/circles -->
    <div class="dots-container">
      <div v-for="(image, index) in images" class="dot" :class="{ active: image.isShown }">
        <span @click="currentSlide({ index } + 1)"></span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Carousel",
  data() {
    return {
      images: [
        { title: "Megami.no.Café.Terrace.full.3925082.jpg", desc: "Літнє кафе та його богині", isShown: true},
        { title: "Kimetsu.no.Yaiba.3.jpg", desc: "Клинок, який знищує демонів 3", isShown: false},
        { title: "Jigokuraku.jpg", desc: "Пеклорай", isShown: false},
      ],
      timer: null,
      slideIndex : 0
    }
  },
  mounted: function () {
    this.startAutoSlider();
  },
  computed: {
    nextSlide() {

    }
  },
  beforeUnmount() {
    clearInterval(this.timer);
  },
  methods: {
    startAutoSlider: function() {
      this.timer = setInterval(this.slideForward, 4000);
    },

    slideForward: function () {
      this.images[this.slideIndex].isShown = false;
      this.slideIndex++;
      if (this.slideIndex >= this.images.length) {
        this.slideIndex = 0;
      }
      this.images[this.slideIndex].isShown = true;
    },

    slideBackward: function() {
      this.images[this.slideIndex].isShown = false;
      this.slideIndex--;
      if (this.slideIndex < 0) {
        this.slideIndex = this.images.length - 1;
      }
      this.images[this.slideIndex].isShown = true;
    }
  }
}
</script>

<style lang="scss" scoped>
* {
  box-sizing: border-box
}

.carousel-container {
  //width: fit-content;
  margin: 0 auto;
  //padding: 15px;
  //background-color: $light-gray;
  background-color: #fff5ee;
  //background-color: #F8F8FF;
  border-radius: 0 0 17vw 17vw;
}

/* Slideshow container */
.slideshow-container {
  max-width: 1280px;
  position: relative;
  margin: 0 auto;
}

/* Hide the images by default */
.mySlides {
  display: none;
}

.shown {
  display: block;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: $bloody-red;
  background-color: $light-gray;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 5px 5px 0;
  user-select: none;
  opacity: 0.6;
}

.next {
  opacity: 0.6;
  right: 0;
  border-radius: 5px 0 0 5px;
}

.prev {
  opacity: 0.6;
  left: 0;
}

.prev:hover, .next:hover {
  background-color: $bg-black;
  color: darkorange;
}

/* Caption text */
.text {
  color: $light-gray;
  background-color: $bg-black;
  font-size: 20px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  //margin: 0 auto;
  width: 100%;
  text-align: center;
  opacity: 0.6;
}

/* Number text (1/3 etc) */
.numbertext {
  color: $light-gray;
  background-color: $bg-black;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
  opacity: 0.6;
}

.dots-container {
  text-align: center;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: $bg-black;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: darkorange;
}

.dot:hover {
  background-color: $bloody-red;
}

/* Fading animation */
.fade {
  animation-name: fade;
  animation-duration: 1.5s;
}

@keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
}
</style>