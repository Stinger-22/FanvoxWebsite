<template>
  <div id="anime-container">
    <div class="anime-entity">
      <div class="anime-title">
          <h2>{{ anime.ukrainianName }}</h2>
      </div>
      <div class="anime-details">
        <div class="text-box">
          <dt>Оригінальна назва: </dt><p>{{ anime.originalName }}</p>
          <hr>
          <dt>Назва: </dt>
          <p>{{ anime.ukrainianName }}</p>
          <hr>
          <dt>Рік виходу: </dt><p>{{ anime.year }}</p>
          <hr>
          <dt>Жанр: </dt>
          <hr>
          <dt>Студія: </dt>
          <hr>
          <dt>Опис: </dt><p>{{ anime.description }}</p>
        </div>
        <div class="anime-cover">
          <img v-bind:src="'http://localhost:8080/api/images/' + anime.coverImageName + '.jpg'" v-bind:alt="anime.coverImageName">
        </div>
      </div>
      <div class="media-player">

        <video></video>
      </div>
    </div>
  </div>
</template>

<script>
import TemplatePage from "@/components/TemplatePage.vue";
import axios from "axios";

export default {
  name: "AnimeView",
  components: {TemplatePage},
  props: ['id'],
  data() {
    return {
      anime: {}
    }
  },
  mounted() {
    axios.get("http://localhost:8080/api/anime/" + this.id)
        .then(response => {
          this.anime = response.data
          console.log(this.anime)
        })
        .catch(e => {
          console.log(e.message)
        });
  }
}
</script>

<style lang="scss" scoped>

#anime-container {
  max-width: 1280px;
  margin: 0 auto;
  background-color: $light-gray;
  position: center;
}

.anime-entity {
  padding: 10px;
  border: 3px solid #f0f0f0;
  box-shadow: inset 0 0 0 1px #d4d4d4;
  margin-bottom: 10px;

  .anime-title {
    text-align: left;
    width: 100%;
    padding: 2px 0 0 2px;
    background-color: $bloody-red;

    color: white;
    text-transform: uppercase;
  }

  .anime-details {
    display: flex;
    flex-wrap: nowrap;
    padding-top: 3px;

    .text-box {
      text-align: left;
      border: 2px solid #f0f0f0;
      box-shadow: inset 0 0 0 1px #d4d4d4;

      dt {
        float: left;
        color: darkorange;
        margin: 0 5px 0 0;
        padding-left: 3px;
      }

      p {
        padding-left: 3px;
      }
    }

    .anime-cover {
      border: 2px solid #f0f0f0;
      box-shadow: inset 0 0 0 1px #d4d4d4;
      padding: 4px 4px 4px 5px
    }
  }
}

img {
  max-width: 250px;
  height: auto;
}

</style>