<template>
  <div class="carousel">
    <slot :currentSlide="currentSlide"></slot>
    <a class="prev" @click="prev">&#10094; Previous</a>
    <a class="next" @click="next">&#10095; Next</a>
  </div>
</template>

<script>

export default {
  name: "Carousel",
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
  mounted: function () {
    this.startSlide();
  },
  methods: {
    startSlide: function () {
      this.timer = setInterval(this.next, 4000);
    },

    next: function () {
      this.currentIndex += 1;
    },

    prev: function () {
      this.currentIndex -= 1;
    },
  }
}

</script>

<style scoped>

</style>