<template>
  <!-- Slideshow container -->
  <div class="slideshow-container">

    <!-- Full-width images with number and caption text -->
    <div class="mySlides fade">
      <div class="numbertext">1 / 3</div>
      <img :src="require(`../assets/carouselongoing/Megami.no.Café.Terrace.full.3925082.jpg`)" style="width:100%">
      <div class="text">Літнє кафе та його богині</div>
    </div>

    <div class="mySlides fade">
      <div class="numbertext">2 / 3</div>
      <img :src="require(`../assets/carouselongoing/Kimetsu.no.Yaiba.3.jpg`)" style="width:100%">
      <div class="text">Клинок, який знищує демонів</div>
    </div>

    <div class="mySlides fade">
      <div class="numbertext">3 / 3</div>
      <img :src="require(`../assets/carouselongoing/Jigokuraku.jpg`)" style="width:100%">
      <div class="text">Пеклорай</div>
    </div>

    <!-- Next and previous buttons -->
    <a class="prev" @click="plusSlides(-1)">&#10094;</a>
    <a class="next" @click="plusSlides(1)">&#10095;</a>
  </div>
  <br>

  <!-- The dots/circles -->
  <div style="text-align:center">
    <span class="dot" @click="currentSlide(1)"></span>
    <span class="dot" @click="currentSlide(2)"></span>
    <span class="dot" @click="currentSlide(3)"></span>
  </div>
</template>

<script>
export default {
  name: "NewCarousel",
  data() {
    return {
      images: [
        "Megami.no.Café.Terrace.full.3925082.jpg",
        "Kimetsu.no.Yaiba.3.jpg",
        "Jigokuraku.jpg"
      ],
      timer: null,
      slideIndex : 0
    }
  },
  mounted: function () {
    this.autoSliding();
  },
  methods: {
    plusSlides: function (n) {
      this.showSlides(this.slideIndex += n);
    },

    currentSlide: function (slideNumber) {
      this.showSlides(this.slideIndex = slideNumber);
    },

    showSlides: function (n) {
      let i;
      let slides = document.getElementsByClassName("mySlides");
      let dots = document.getElementsByClassName("dot");
      if (n > slides.length) {this.slideIndex = 1}
      if (n < 1) {this.slideIndex = slides.length}
      for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
      }
      for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
      }
      slides[this.slideIndex-1].style.display = "block";
      dots[this.slideIndex-1].className += " active";
    },

    autoSliding: function () {
      let i;
      let slides = document.getElementsByClassName("mySlides");
      let dots = document.getElementsByClassName("dot");
      for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
      }
      this.slideIndex++;
      if (this.slideIndex > slides.length) {this.slideIndex = 1}
      for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
      }
      slides[this.slideIndex-1].style.display = "block";
      dots[this.slideIndex-1].className += " active";
      setTimeout(this.autoSliding, 4000);
    }
  }
}
</script>

<style lang="scss" scoped>
* {
  box-sizing: border-box
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

.active, .dot:hover {
  background-color: darkorange;
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