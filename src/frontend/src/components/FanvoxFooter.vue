<template>
  <footer>
    <div class="footer-section">
      <p class="heading-text">Корисні посилання</p>
    </div>
  </footer>
</template>

<script>
export default {
  name: "FanvoxFooter"
}
</script>

<style lang="scss" scoped>

footer {
  display: flex;
  align-items: center;
  justify-content: center;
  border-top: 3px solid $bloody-red;
}

.footer-section {
  //width: 50%;
}

.heading-text {
  font-family: Kelly Slab, Arial, Helvetica, sans-serif;
  font-size: 30px;
  font-weight: bold;
  color: $light-gray;
}

</style>