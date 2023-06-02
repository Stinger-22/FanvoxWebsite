<template>
  <div class="template-container">
    <div id="news-side">
      <p>NEWS</p>
    </div>
    <slot></slot>
    <div id="updates-side">
      <p>UPDATES</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "TemplatePage"
}
</script>

<style lang="scss" scoped>

.template-container {
  max-width: 1280px;
  margin: 0 auto;
  background-color: $light-gray;
  position: center;

  display: grid;
  grid-template-columns: 20% 60% 20%;
}

#news-side {
  background-color: $light-gray;
}

#updates-side {
  background-color: $light-gray;
}

</style>