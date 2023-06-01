<template>
  <FanvoxHeader></FanvoxHeader>
  <router-view/>
</template>

<style lang="scss">
#app {
  font-family: Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;

  background-color: $bg-black;
}
</style>

<script setup>
import FanvoxHeader from "@/components/FanvoxHeader.vue";
</script>