<template>
  <div class="template-container">
    <div id="news-side">
      <p class="side-title">Новини</p>
      <div class="side-box">
        <p>
          Працюємо для вашого задоволення без вихідних, свят та відпусток, тож нагадуємо, що вдячність нам можна висловити не тільки лайком 🙂
          <img :src="require(`../assets/img/kava.jpg`)" alt="persona_start.jpg">
        </p>
      </div>
    </div>
    <slot></slot>
    <div id="updates-side">
      <p class="side-title">Оновлення</p>
      <div class="side-box">
        <p>🔴 Цей прекрасний світ, благословенний вибухом! / Kono Subarashii Sekai ni Bakuen o! (серії 1-6 з 12)<br>

          🔶 Епізод 6 - Мета вибухової нероби</p>
      </div>
      <div class="side-box">
        <p>Новенька серія "Клинка, який знищує демонів" перекладена і віддана на озвучку 🙂
          Очікуйте серійку завтра, постараємося якомога раніше)</p>
      </div>
      <div class="side-box">
        <p>🔴 Персона 4 / Persona 4 The Animation (cерія 1 з 25)<br>🔶 Епізод 1 - Ти - це я, а я - це ти</p>
      </div>
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

  animation-name: smooth-appear;
  animation-duration: 0.2s;

  .side-title {
    font-family: Kelly Slab, Arial, Helvetica, sans-serif;
    font-size: 30px;
    font-weight: bold;
  }

  .side-box {
    text-align: left;
    border: 1px solid #ccc;

    p {
      font-size: 18px;
    }
  }
}

#news-side, #updates-side {
  background-color: $light-gray;
}

#news-side {
  .side-box {
    padding-left: 5px;
  }
}

#updates-side {
  .side-box {
    padding-left: 5px;
  }
}

@media screen and (max-width: 800px) {
  .template-container {
    display: block;
  }

  #news-side {
    display: none;
  }

  #updates-side {
    display: none;
  }
}

img {
  max-width: 100%;
  width: 100%;
  height: auto;
}

</style>