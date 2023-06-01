<template>
  <FanvoxHeader></FanvoxHeader>
  <router-view/>
  <FanvoxFooter></FanvoxFooter>
</template>

<script setup>
// @ is an alias to /src
import FanvoxHeader from "@/components/FanvoxHeader.vue";
import FanvoxFooter from "@/components/FanvoxFooter.vue";
</script>

<style lang="scss">
#app {
  font-family: Arial, Helvetica, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;

  background-color: $bg-black;
  font-size: 20px;
}
</style>