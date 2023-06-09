<template>
  <div id="anime-container">
    <div class="anime-entity">
      <div class="anime-title">
          <h2>{{ anime.ukrainianName }}</h2>
      </div>
      <div class="anime-details">
        <div class="text-box">
          <dt>Оригінальна назва: </dt><p>{{ anime.originalName }}</p>
          <hr>
          <dt>Назва: </dt>
          <p>{{ anime.ukrainianName }}</p>
          <hr>
          <dt>Рік виходу: </dt><p>{{ anime.year }}</p>
          <hr>
          <dt>Жанр: </dt><p>?</p>
          <hr>
          <dt>Студія: </dt><p>?</p>
          <hr>
          <dt>Опис: </dt><p>{{ anime.description }}</p>
        </div>
        <div class="anime-cover">
          <img v-bind:src="'http://localhost:8080/api/images/' + anime.coverImageName + '.jpg'" v-bind:alt="anime.coverImageName">
        </div>
      </div>
      <div class="media-player">
        <CustomizedVideo :video="'http://localhost:8080/api/videos/' + currentEpisode + '.mp4'"></CustomizedVideo>
        <div class="episodes-buttons-container">
          <ul class="episodes">
<!--            <li class="episode-button" v-for="(episode, index) in episodes">{{index + 1}} серія</li>-->
            <li class="episode-button" v-for="(episode, index) in episodes" v-on:click="changeEpisode(index)">{{index + 1}} серія</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TemplatePage from "@/components/TemplatePage.vue";
import axios from "axios";
import CustomizedVideo from "@/components/CustomizedVideo.vue";

export default {
  name: "AnimeView",
  components: {CustomizedVideo, TemplatePage},
  props: ['id'],
  data() {
    return {
      anime: {},
      episodes: [
          "megumin01-online",
          "megumin02-online",
          "megumin03-online",
          "megumin04-online",
          "megumin05-online",
          "megumin06-online"
      ],
      currentEpisode: {},
      player: {}
    }
  },
  mounted() {
    this.currentEpisode = this.episodes[0]
    this.player = document.getElementById('justPlayer');

    axios.get("http://localhost:8080/api/anime/" + this.id)
        .then(response => {
          this.anime = response.data
        })
        .catch(e => {
          console.log(e.message)
        });

    let isDown = false;
    let startX;
    let scrollLeft;
    const slider = document.querySelector('.episodes');

    const end = () => {
      isDown = false;
      slider.classList.remove('active');
    }

    const start = (e) => {
      isDown = true;
      slider.classList.add('active');
      startX = e.pageX || e.touches[0].pageX - slider.offsetLeft;
      scrollLeft = slider.scrollLeft;
    }

    const move = (e) => {
      if(!isDown) return;

      e.preventDefault();
      const x = e.pageX || e.touches[0].pageX - slider.offsetLeft;
      const dist = (x - startX);
      slider.scrollLeft = scrollLeft - dist;
    }

    (() => {
      slider.addEventListener('mousedown', start);
      slider.addEventListener('touchstart', start);

      slider.addEventListener('mousemove', move);
      slider.addEventListener('touchmove', move);

      slider.addEventListener('mouseleave', end);
      slider.addEventListener('mouseup', end);
      slider.addEventListener('touchend', end);
    })();
  },
  methods: {
    changeEpisode: function(newEpisodeIndex) {
      this.player.pause();
      this.currentEpisode = this.episodes[newEpisodeIndex]
      this.player.load();
    },
  }
}
</script>

<style lang="scss" scoped>

#anime-container {
  max-width: 1280px;
  margin: 0 auto;
  background-color: $light-gray;
  position: center;
}

.anime-entity {
  .anime-title {
    text-align: left;
    width: 100%;
    padding: 2px 0 0 2px;
    background-color: $bloody-red;

    color: white;
    text-transform: uppercase;
  }

  .anime-details {
    display: flex;
    flex-wrap: nowrap;
    padding-top: 3px;

    .text-box {
      text-align: left;
      border: 2px solid #f0f0f0;
      box-shadow: inset 0 0 0 1px #d4d4d4;

      dt {
        float: left;
        color: darkorange;
        margin: 0 5px 0 0;
        padding-left: 3px;
      }

      p {
        padding-left: 3px;
      }
    }

    .anime-cover {
      border: 2px solid #f0f0f0;
      box-shadow: inset 0 0 0 1px #d4d4d4;
      padding: 4px 4px 4px 5px
    }
  }
}

img {
  max-width: 250px;
  height: auto;
}

.media-player {

}

.episodes-buttons-container {
  position: relative;
  background-color: black;

  // Gradient side fade
  &:before, &:after {
    position: absolute;
    top: 0;
    z-index: 1;

    content: "";
    display: block;
    width: 20px;
    height: 100%;
  }

  &:before {
    left: 0;
    background: linear-gradient(90deg, black, transparent);
  }

  &:after {
    right: 0;
    background: linear-gradient(-90deg, black, transparent);
  }
}

.episodes {
  position: relative;
  width: 100%;
  overflow: hidden;
  white-space: nowrap;
  font-size: 0;
  cursor: pointer;

  &.active {
    cursor: grab;
  }
}

.episode-button {
  display: inline-block;
  margin-left: 20px;
  user-select: none;

  background: $bloody-red;
  width: 50%;
  height: 70px;
  color: white;
  //font-size: 33px;
  font-weight: bold;
  line-height: 70px;

  &:last-child {
    margin-right: 20px;
  }
}

@media screen and (min-width: 500px) {
  .episode-button {
    width: 33%;
  }
}

@media screen and (min-width: 800px) {
  .episode-button {
    width: 25%;
  }
}

@media screen and (min-width: 1200px) {
  //.episodes-buttons-container {
  //  margin-left: -20px;
  //}
  .episode-button {
    width: 20%;
  }
}



</style>