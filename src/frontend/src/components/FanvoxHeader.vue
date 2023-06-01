<template>
  <header>
    <div id="header_img_container">
      <img id="header_img" alt="Fanvox logo" src="../assets/header_bg_origin.jpg" width="1600" height="400">
    </div>
    <nav>
      <ul>
        <li><router-link to="/"><span>Головна</span></router-link></li>
        <li><router-link :to="{ name: 'News' }">Новини</router-link></li>
        <li><router-link :to="{ name: 'Catalog' }">Каталог аніме</router-link></li>
        <li><router-link :to="{ name: 'Dubbing' }">Зараз озвучується</router-link></li>
        <li><router-link :to="{ name: 'About' }">Про нас</router-link></li>
      </ul>
    </nav>
  </header>
</template>

<script>
export default {
  name: "FanvoxHeader"
}
</script>

<style lang="scss" scoped>

header {
  font-family: Kelly Slab, sans-serif;
}

#header_img {
  max-width: 100%;
  height: auto;
}

nav {
  border-top: 3px solid $bloody-red;
  border-bottom: 3px solid $bloody-red;

  a {
    margin: 2px;
    padding: 0 7px;
    font-size: 30px;
    font-weight: bold;
    color: $light-gray;
    text-decoration: none;

    &.router-link-exact-active {
      color: darkorange;
    }

    &:hover {
        color: #ff5733;
        transition: 0.5s;
    }
  }
}

ul {
  list-style:none;
  margin: 0;
  padding: 0 7px;

  li {
    display: inline-block;
    padding: 7px 7px;
    position: relative;
    border-right: 1px $light-gray solid;
  }
  li:last-child {
    border-right: none;
  }
}


</style>