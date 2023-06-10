<template>
  <div class="home-container">
    <Carousel></Carousel>
    <div id="short-about-us">
      <p>Ми українська команда озвучення аніме. Працюємо як на кількість, так і на якість. Також займаємся озвученням мультсеріалів, серіалів, ігрового та youtube-відео українською.</p>
    </div>
    <br>
    <h2>Зараз озвучуємо</h2>
    <OngoingGrid></OngoingGrid>
    <br>

    <h2>Почали озвучувати: Персона 4 / Persona 4 The Animation</h2>
    <div class="new-dub">
      <router-link :to="'/anime/4'">
        <img :src="require(`../assets/img/news/persona_start.jpg`)" alt="persona_start.jpg">
      </router-link>
      <p>Коли Нарукамі Юу переїжджає до віддаленого містечка Інаба, він очікує набагато більше тиші та спокою, ніж він звик у великому місті. Натомість тишу було зруйновано, і єдиною тишею стала тиша могили, коли містечко охопила низка таємничих убивств і викрадень. Поліція загнана в глухий кут і Юу приєднується до групи з восьми інших підлітків у відчайдушній спробі розгадати таємницю. Таємниця якимось чином пов’язана як з місцевими погодними умовами і з дивним світом відеоігор, у який можуть потрапити Юу, його друзі та загадковий вбивця. Це місце, де кожен повинен володіти унікальною зброєю та навчитися використовувати дивовижні сили, якщо хоче вижити.</p>
    </div>

  </div>
</template>

<script>

import Carousel from "@/components/Carousel.vue";
import OngoingGrid from "@/components/OngoingGrid.vue";

export default {
  name: 'HomeView',
  components: {
    OngoingGrid,
    Carousel
  }
}
</script>

<style lang="scss" scoped>

* {
  padding: 0;
  margin: 0;
}

.home-container {
  max-width: 1280px;
  margin: 0 auto;
  background-color: $light-gray;
  position: center;

  animation-name: smooth-appear;
  animation-duration: 0.2s;

  .new-dub {
    width: 80%;
    margin: 0 auto;
    padding-top: 5px;
    padding-bottom: 5px;

    img {
      width: 80%;
    }
  }
}

#short-about-us {
  margin: 0 auto;
  max-width: 80%;
}

</style>