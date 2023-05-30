<template>
  <header>
    <div id="header_img_container">
      <img id="header_img" alt="Fanvox logo" src="../assets/header_bg_origin.jpg" width="1600" height="400">
    </div>
    <nav>
      <router-link to="/">Головна</router-link>
      <router-link :to="{ name: 'News' }">Новини</router-link>
      <router-link :to="{ name: 'Catalog' }">Каталог аніме</router-link>
      <router-link :to="{ name: 'Dubbing' }">Зараз озвучується</router-link>
      <router-link :to="{ name: 'About' }">Про нас</router-link>
    </nav>
  </header>
</template>

<script>
export default {
  name: "FanvoxHeader"
}
</script>

<style lang="scss" scoped>

#header_img_container {
  background-color: $bg-dark;
}

#header_img {
  max-width: 100%;
  height: auto;
}

nav {
  display: flex;
  margin: 0 auto;
  padding: 30px;
  border-top: 3px solid #DA251D;
  border-bottom: 3px solid #DA251D;
  justify-content: center;

  a {
    margin: 2px;
    padding: 0 5px;
    font-size: 20px;
    font-weight: bold;
    color: #2c3e50;
    text-decoration: none;

    &.router-link-exact-active {
       color: #42b983;
     }
  }
}
</style>