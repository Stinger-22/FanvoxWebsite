<template>
  <TemplatePage>
    <div id="about">
      <p>Працюємо для вашого задоволення без вихідних, свят та відпусток, тож нагадуємо, що вдячність нам можна висловити не тільки лайком</p>
      <div id="support-container">
        <h1>Разова подяка - подяка загалом за нашу роботу</h1>
        <ul>
          <li><a href="https://fanvoxua.diaka.ua/onetime_diaka">Diaka</a></li>
        </ul>
        <h1>Щомісячна підтримка - з бонусами для вас</h1>
        <ul>
          <li><a href="https://www.patreon.com/fvua">Patreon</a></li>
          <li><a href="https://www.buymeacoffee.com/fanvoxua">Buy Me a Coffee</a></li>
        </ul>
      </div>
      <img id="donation-img" alt="Support us with donations" src="../assets/img/donation.jpg" width="1280" height="800">
    </div>
  </TemplatePage>
</template>

<script>
import TemplatePage from "@/components/TemplatePage.vue";

export default {
  name: "SupportView",
  components: {TemplatePage}
}
</script>

<style lang="scss" scoped>

#donation-img {
  max-width: 100%;
  height: auto;
  margin-bottom: -5px;
}

#about {
  padding: 5px 5px 0 5px;
  text-align: center;
}

#support-container {
  text-align: left;
}

li {
  margin-left: 20px;
}

a {
  text-decoration: none;
}

a:hover {
  color: #ff5733;
  transition: 0.5s;
}

</style>