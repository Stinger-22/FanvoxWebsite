<template>
  <div class="video-container">
    <Carousel></Carousel>
    <SearchBar></SearchBar>
    <div id="short-about-us">
      <p>Ми українська команда озвучення аніме. Працюємо як на кількість, так і на якість. Також займаємся озвученням мультсеріалів, серіалів, ігрового та youtube-відео українською.</p>
    </div>
    <br>
    <h2>Зараз озвучуємо</h2>
    <OngoingGrid></OngoingGrid>
    <br>

    <p>cras pulvinar mattis nunc sed blandit libero volutpat sed cras ornare arcu dui vivamus arcu felis bibendum ut tristique et egestas quis ipsum suspendisse ultrices gravida dictum fusce ut placerat orci nulla pellentesque dignissim enim sit amet venenatis urna cursus eget nunc scelerisque viverra mauris in aliquam sem fringilla ut morbi tincidunt augue interdum velit euismod in pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id aliquet risus feugiat in ante metus dictum at tempor commodo ullamcorper a lacus vestibulum sed arcu non odio euismod lacinia at quis risus sed vulputate odio ut enim blandit volutpat maecenas volutpat blandit</p>

  </div>
</template>

<script>

import Carousel from "@/components/Carousel.vue";
import SearchBar from "@/components/SearchBar.vue";
import OngoingGrid from "@/components/OngoingGrid.vue";

export default {
  name: 'HomeView',
  components: {
    OngoingGrid,
    SearchBar,
    Carousel,
  }
}
</script>

<style lang="scss" scoped>

* {
  padding: 0;
  margin: 0;
}

.video-container {
  max-width: 1280px;
  margin: 0 auto;
  background-color: $light-gray;
  position: center;
}

#short-about-us {
  margin: 0 auto;
  max-width: 80%;
}

</style>