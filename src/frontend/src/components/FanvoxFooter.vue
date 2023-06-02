<template>
  <footer>
    <p class="heading-text">Корисні посилання</p>
    <div class="footer-section">
      <a href="https://t.me/fvua_mkv">Patreon</a><br>
      <a href="https://t.me/fvua_mkv">Buy Me a Coffee</a><br>
      <a href="https://t.me/fvua_mkv">Diaka</a><br>
      <a href="https://t.me/fanvoxua_re">Телеграм</a><br>
      <a href="https://t.me/fanvoxua_bot">Телеграм бот для перегляду аніме</a><br>
      <a href="https://t.me/fanvoxua_video">Серії в телеграмі</a><br>
      <a href="https://t.me/fvua_mkv">Серії без втрати якості</a><br>
    </div>
    <p class="heading-text">2023</p>
  </footer>
</template>

<script>
export default {
  name: "FanvoxFooter"
}
</script>

<style lang="scss" scoped>

footer {
  text-align: center;
  border-top: 3px solid $bloody-red;
}

.footer-section {
  margin: 0 auto;
  max-width: 400px;
  text-align: left;

  a {
    text-decoration: none;
    color: white;
  }

  a:hover {
    color: #ff5733;
    transition: 0.5s;
  }
}

.heading-text {
  font-family: Kelly Slab, Arial, Helvetica, sans-serif;
  font-size: 30px;
  font-weight: bold;
  color: $light-gray;
  padding: 7px 0;
}

</style>