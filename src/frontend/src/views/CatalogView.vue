<template>
  <TemplatePage>
    <div id="catalog-container">
<!--      <SearchBar></SearchBar>-->
      <input type="text" v-model="search" placeholder="Пошук">
<!--      <div id="tag-container">-->
<!--        <button v-for="genre in genres">{{genre.name}}</button>-->
<!--      </div>-->
      <div id="anime-container">
        <div class="anime-entity" v-for="anime in matchingAnimes" :key="anime.id">
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
              <dt>Жанр: </dt>
              <span v-for="(genre, index) in anime.genres">{{genre.name}}<span v-if="index !== anime.genres.length - 1">, </span></span>
              <hr>
              <dt>Студія: </dt>
              <span v-for="(studio, index) in anime.studios">{{studio.name}}<span v-if="index !== anime.studios.length - 1">, </span></span>
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
import {computed, ref} from "vue";

export default {
  name: "CatalogView",
  components: {TemplatePage},
  setup() {
    const search = ref('')

    let animes = ref([])
    let matchingAnimes;
    axios.get("http://localhost:8080/api/anime/all")
        .then(response => {
          animes.value = response.data
        })
        .catch(e => {
          console.log(e.message)
        });

    matchingAnimes = computed(() => {
      return animes.value.filter((anime) => {
        return anime.originalName.toLowerCase().includes(search.value.toLowerCase()) || anime.ukrainianName.toLowerCase().includes(search.value.toLowerCase())
      })
    })

    return {
      search, animes, matchingAnimes
    }
  }
}
</script>

<style lang="scss" scoped>

#catalog-container {
  input[type=text] {
    padding: 6px;
    margin: 8px 0;
    border: none;
    width: 30%;
  }
}

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
        font-size: 18px;
      }

      p {
        padding-left: 3px;
        padding-right: 3px;
        font-size: 18px;
      }

      span {
        font-size: 18px;
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