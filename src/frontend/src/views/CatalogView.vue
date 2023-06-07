<template>
  <TemplatePage>
    <div class="catalog">
      <h1>This is a catalog page</h1>
      <div id="tag-container">
        <button v-for="genre in genres">{{genre.name}}</button>
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
        })
  }
}
</script>

<style scoped>

#tag-container {
  display: block;
}

</style>