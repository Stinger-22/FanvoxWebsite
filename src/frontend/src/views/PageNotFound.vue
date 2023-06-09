<template>
  <div class="error-container">
    <p id="error-404">404</p>
    <p id="error-text">Page Not Found</p>
    <br>
  </div>
</template>

<script>
export default {
  name: "PageNotFound"
}
</script>

<style lang="scss" scoped>

.error-container {
  max-width: 1280px;
  margin: 0 auto;
  background-color: $light-gray;
  position: center;

  font-family: Kelly Slab, Arial, Helvetica, sans-serif;

  #error-404 {
    font-size: 10em;
  }

  #error-text {
    font-size: 6em;
  }

  animation-name: smooth-appear;
  animation-duration: 0.2s;
}

</style>