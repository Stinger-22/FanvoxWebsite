<template>
  <p>This is carousel</p>
<!--  <img v-bind:src="currentImg" />-->
  <div>
    <transition-group name="fade" tag="div">
      <div v-for="i in [currentIndex]" :key="i">
        <img :src="getImgUrl(currentImg)" />
<!--        <img v-bind:src="currentImg" />-->
<!--        <img :src="require(`${currentImg}`)" />-->
      </div>
    </transition-group>
    <a class="prev" @click="prev">&#10094; Previous</a>
    <a class="next" @click="next">&#10095; Next</a>
  </div>
</template>

<script>
export default {
  name: "CarouselOngoing",
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
    startSlide: function() {
      this.timer = setInterval(this.next, 4000);
    },

    next: function() {
      this.currentIndex += 1;
    },

    prev: function() {
      this.currentIndex -= 1;
    },

    getImgUrl: function (img) {
      return require('@/assets/carouselongoing/' + img);
    }
  },

  computed: {
    currentImg: function() {
      return this.images[Math.abs(this.currentIndex) % this.images.length];
    }
  }
}
</script>

<style scoped>
img {
  max-width: 100%;
  height: auto;
  /*max-height: ;*/
}
</style>