<template>
  <TemplatePage>
    <div class="dubbing-container">
      <div class="ongoing-grid">
        <div v-for="anime in animes" class="tile">
          <router-link :to="'/anime/' + anime.id">
            <img :src="'http://localhost:8080/api/images/' + anime.coverImageName + '.jpg'" v-bind:alt="anime.coverImageName">
          </router-link>
        </div>
      </div>
    </div>
  </TemplatePage>
</template>

<script>
import TemplatePage from "@/components/TemplatePage.vue";
import {ref} from "vue";
import axios from "axios";

export default {
  name: "DubbingView",
  components: {TemplatePage},
  setup() {
    let animes = ref([])
    axios.get("http://localhost:8080/api/anime/dubbing")
        .then(response => {
          animes.value = response.data
          console.log(animes.value)
        })
        .catch(e => {
          console.log(e.message)
        });

    return {
      animes
    }
  }
}
</script>

<style lang="scss" scoped>

.ongoing-grid {
  padding: 1vh 2vw;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 5px;
}

.tile {
  position: relative;
  
  img {
    max-width: 100%;
    display: block;

    width: 320px;
    height: auto;
  }
}

</style>