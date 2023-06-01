<template>
  <div class="container">
    <h1>This is a home page</h1>
    <p>cras pulvinar mattis nunc sed blandit libero volutpat sed cras ornare arcu dui vivamus arcu felis bibendum ut tristique et egestas quis ipsum suspendisse ultrices gravida dictum fusce ut placerat orci nulla pellentesque dignissim enim sit amet venenatis urna cursus eget nunc scelerisque viverra mauris in aliquam sem fringilla ut morbi tincidunt augue interdum velit euismod in pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id aliquet risus feugiat in ante metus dictum at tempor commodo ullamcorper a lacus vestibulum sed arcu non odio euismod lacinia at quis risus sed vulputate odio ut enim blandit volutpat maecenas volutpat blandit</p>
<!--    <CarouselOngoing></CarouselOngoing>-->
<!--    <Carousel class="carousel">-->
<!--      <Slide v-for="(slide, index) in carouselSlides" :key="index">-->
<!--        <img style="max-width: 100%; height: auto;" :src="require(`../assets/carouselongoing/${slide}`)" alt="" />-->
<!--      </Slide>-->
<!--    </Carousel>-->
    <NewCarousel></NewCarousel>

    <p>cras pulvinar mattis nunc sed blandit libero volutpat sed cras ornare arcu dui vivamus arcu felis bibendum ut tristique et egestas quis ipsum suspendisse ultrices gravida dictum fusce ut placerat orci nulla pellentesque dignissim enim sit amet venenatis urna cursus eget nunc scelerisque viverra mauris in aliquam sem fringilla ut morbi tincidunt augue interdum velit euismod in pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id aliquet risus feugiat in ante metus dictum at tempor commodo ullamcorper a lacus vestibulum sed arcu non odio euismod lacinia at quis risus sed vulputate odio ut enim blandit volutpat maecenas volutpat blandit</p>
  </div>
</template>

<script>
// @ is an alias to /src

import Carousel from "@/components/carousel/Carousel.vue";
import Slide from "@/components/carousel/Slide.vue";
import CarouselOngoing from "@/components/CarouselOngoing.vue";
import NewCarousel from "@/components/NewCarousel.vue";

export default {
  name: 'HomeView',
  components: {
    NewCarousel,
    CarouselOngoing,
    Slide,
    Carousel,
  },
  setup() {
    const carouselSlides = [
      "Megami.no.Café.Terrace.full.3925082.jpg",
      "Kimetsu.no.Yaiba.3.jpg"
    ];

    return { carouselSlides };
  },
  data() {
    return {
      images: [
        "Megami.no.Café.Terrace.full.3925082.jpg",
        "Kimetsu.no.Yaiba.3.jpg"
      ],
      timer: null,
      currentIndex: 0
    }
  },
}
</script>

<style lang="scss" scoped>

.p {
  padding: 0;
  margin: 0;
}

.container {
  padding: 0;
  max-width: 1600px;
  margin: 0 auto;
  background-color: #dddddd;
  //padding: 20px;
  //border-radius: 10px;
  position: center;
}

/* Hide the images by default */
.slide {
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
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
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