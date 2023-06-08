<template>
  <TemplatePage>
    <div class="catalog">
      <h1>This is a catalog page</h1>
      <div id="tag-container">
        <button v-for="genre in genres">{{genre.name}}</button>
      </div>
      <div id="anime-container">
        <div class="anime-entity" v-for="anime in animes" :key="anime.id">
          <div class="anime-title">
            <router-link :to="{ name: 'Anime', params: { id: anime.id } } ">
              {{ anime.ukrainianName }}
            </router-link>
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
              <dt>Опис: </dt><p>{{ anime.description }}</p>
            </div>
            <div class="anime-cover">
              <img v-bind:src="'http://localhost:8080/api/images/' + anime.coverImageName + '.jpg'" v-bind:alt="anime.coverImageName">
            </div>
          </div>
        </div>
      </div>
    </div>
  </TemplatePage>
</template>

<script>
import TemplatePage from "@/components/TemplatePage.vue";
import axios from "axios";

export default {
  name: "CatalogView",
  components: {TemplatePage},
  data() {
    return {
      genres: [
      ],
      animes: [
      ]
    }
  },
  mounted() {
    axios.get("http://localhost:8080/api/genre/all")
        .then(response => {
          this.genres = response.data
        })
        .catch(e => {
          console.log(e.message)
        });
    axios.get("http://localhost:8080/api/anime/all")
        .then(response => {
          console.log(response)
          this.animes = response.data
        })
        .catch(e => {
          console.log(e.message)
        });
  }
}
</script>

<style lang="scss" scoped>

#tag-container {
  display: block;
}

#anime-container {

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

    a {
      text-decoration-line: none;
      text-transform: uppercase;
      color: white;
    }

    a:hover {
      text-decoration-line: underline;
    }
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