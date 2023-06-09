<template>
  <div class="video-container show-controls">
    <div class="wrapper">
      <div class="video-timeline">
        <div class="progress-area">
          <span>00:00</span>
          <div class="progress-bar"></div>
        </div>
      </div>
      <ul class="video-controls">
        <li class="options left">
          <button class="volume"><i class="fa-solid fa-volume-high"></i></button>
          <input type="range" min="0" max="1" step="any">
          <div class="video-timer">
            <p class="current-time">00:00</p>
            <p class="separator"> / </p>
            <p class="video-duration">00:00</p>
          </div>
        </li>
        <li class="options center">
          <button class="skip-backward"><i class="fas fa-backward"></i></button>
          <button class="play-pause"><i class="fas fa-play"></i></button>
          <button class="skip-forward"><i class="fas fa-forward"></i></button>
        </li>
        <li class="options right">
          <button class="fullscreen"><i class="fa-solid fa-expand"></i></button>
        </li>
      </ul>
    </div>
    <video id="justPlayer" v-on:click="videoPlaySwitch()">
      <source v-bind:src="video" type="video/mp4">
    </video>
  </div>
</template>

<script>
export default {
  name: "CustomizedVideo",
  props: ['video'],
  data() {
    return {
      timer: {},
      mainVideo: {}
    }
  },
  mounted() {
    const container = document.querySelector(".video-container"),
        videoTimeline = container.querySelector(".video-timeline"),
        progressBar = container.querySelector(".progress-bar"),
        volumeBtn = container.querySelector(".volume i"),
        volumeSlider = container.querySelector(".left input"),
        currentVidTime = container.querySelector(".current-time"),
        videoDuration = container.querySelector(".video-duration"),
        skipBackward = container.querySelector(".skip-backward i"),
        skipForward = container.querySelector(".skip-forward i"),
        playPauseBtn = container.querySelector(".play-pause i"),
        fullScreenBtn = container.querySelector(".fullscreen i");

    this.mainVideo = container.querySelector("video");
    console.log(this.mainVideo)

    let timer;

    const hideControls = () => {
      if(this.mainVideo.paused) return;
      timer = setTimeout(() => {
        container.classList.remove("show-controls");
      }, 3000);
    }
    hideControls();

    container.addEventListener("mousemove", () => {
      container.classList.add("show-controls");
      clearTimeout(timer);
      hideControls();
    });

    const formatTime = time => {
      let seconds = Math.floor(time % 60),
          minutes = Math.floor(time / 60) % 60,
          hours = Math.floor(time / 3600);

      seconds = seconds < 10 ? `0${seconds}` : seconds;
      minutes = minutes < 10 ? `0${minutes}` : minutes;
      hours = hours < 10 ? `0${hours}` : hours;

      if(hours === 0) {
        return `${minutes}:${seconds}`
      }
      return `${hours}:${minutes}:${seconds}`;
    }

    videoTimeline.addEventListener("mousemove", e => {
      let timelineWidth = videoTimeline.clientWidth;
      let offsetX = e.offsetX;
      let percent = Math.floor((offsetX / timelineWidth) * this.mainVideo.duration);
      const progressTime = videoTimeline.querySelector("span");
      offsetX = offsetX < 20 ? 20 : (offsetX > timelineWidth - 20) ? timelineWidth - 20 : offsetX;
      progressTime.style.left = `${offsetX}px`;
      progressTime.innerText = formatTime(percent);
    });

    videoTimeline.addEventListener("click", e => {
      let timelineWidth = videoTimeline.clientWidth;
      this.mainVideo.currentTime = (e.offsetX / timelineWidth) * this.mainVideo.duration;
    });

    this.mainVideo.addEventListener("timeupdate", e => {
      let {currentTime, duration} = e.target;
      let percent = (currentTime / duration) * 100;
      progressBar.style.width = `${percent}%`;
      currentVidTime.innerText = formatTime(currentTime);
    });

    this.mainVideo.addEventListener("loadeddata", () => {
      videoDuration.innerText = formatTime(this.mainVideo.duration);
    });

    const draggableProgressBar = e => {
      let timelineWidth = videoTimeline.clientWidth;
      progressBar.style.width = `${e.offsetX}px`;
      this.mainVideo.currentTime = (e.offsetX / timelineWidth) * this.mainVideo.duration;
      currentVidTime.innerText = formatTime(this.mainVideo.currentTime);
    }

    volumeBtn.addEventListener("click", () => {
      if(!volumeBtn.classList.contains("fa-volume-high")) {
        this.mainVideo.volume = 0.5;
        volumeBtn.classList.replace("fa-volume-xmark", "fa-volume-high");
      } else {
        this.mainVideo.volume = 0.0;
        volumeBtn.classList.replace("fa-volume-high", "fa-volume-xmark");
      }
      volumeSlider.value = this.mainVideo.volume;
    });

    volumeSlider.addEventListener("input", e => {
      this.mainVideo.volume = e.target.value;
      if(e.target.value === 0) {
        return volumeBtn.classList.replace("fa-volume-high", "fa-volume-xmark");
      }
      volumeBtn.classList.replace("fa-volume-xmark", "fa-volume-high");
    });

    fullScreenBtn.addEventListener("click", () => {
      container.classList.toggle("fullscreen");
      if(document.fullscreenElement) {
        fullScreenBtn.classList.replace("fa-compress", "fa-expand");
        return document.exitFullscreen();
      }
      fullScreenBtn.classList.replace("fa-expand", "fa-compress");
      container.requestFullscreen();
    });

    skipBackward.addEventListener("click", () => this.mainVideo.currentTime -= 5);
    skipForward.addEventListener("click", () => this.mainVideo.currentTime += 5);
    this.mainVideo.addEventListener("play", () => playPauseBtn.classList.replace("fa-play", "fa-pause"));
    this.mainVideo.addEventListener("pause", () => playPauseBtn.classList.replace("fa-pause", "fa-play"));
    playPauseBtn.addEventListener("click", () => this.videoPlaySwitch());
    videoTimeline.addEventListener("mousedown", () => videoTimeline.addEventListener("mousemove", draggableProgressBar));
    document.addEventListener("mouseup", () => videoTimeline.removeEventListener("mousemove", draggableProgressBar));
  },
  methods: {
    videoPlaySwitch: function () {
      this.mainVideo.paused ? this.mainVideo.play() : this.mainVideo.pause()
    },
  }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');

.video-container, .video-controls, .video-timer, .options{
  display: flex;
  align-items: center;
  justify-content: center;
}

.video-container{
  width: 100%;
  user-select: none;
  overflow: hidden;
  max-width: 1280px;
  background: #000;
  //aspect-ratio: 16 / 9;
  position: relative;
  font-family: 'Poppins', sans-serif;
}

.video-container.fullscreen{
  max-width: 100%;
  width: 100%;
  height: 100vh;
  border-radius: 0;
}

.wrapper{
  position: absolute;
  left: 0;
  right: 0;
  z-index: 1;
  opacity: 0;
  bottom: -15px;
  transition: all 0.08s ease;
}

.video-container.show-controls .wrapper{
  opacity: 1;
  bottom: 0;
  transition: all 0.13s ease;
}

.wrapper::before{
  content: "";
  bottom: 0;
  left: 0;
  width: 100%;
  z-index: -1;
  position: absolute;
  height: calc(100% + 35px);
  pointer-events: none;
  background: linear-gradient(to top, rgba(0, 0, 0, 0.7), transparent);
}

.video-timeline{
  height: 7px;
  width: 100%;
  cursor: pointer;
}

.video-timeline .progress-area{
  height: 3px;
  position: relative;
  background: rgba(255, 255, 255, 0.6);
}

.progress-area span{
  position: absolute;
  left: 50%;
  top: -25px;
  font-size: 13px;
  color: #fff;
  pointer-events: none;
  transform: translateX(-50%);
}

.progress-area .progress-bar{
  width: 0;
  height: 100%;
  position: relative;
  background: $bloody-red;
}

.progress-bar::before{
  content: "";
  right: 0;
  top: 50%;
  height: 13px;
  width: 13px;
  position: absolute;
  border-radius: 50%;
  background: darkorange;
  transform: translateY(-50%);
}

.progress-bar::before, .progress-area span{
  display: none;
}

.video-timeline:hover .progress-bar::before,
.video-timeline:hover .progress-area span{
  display: block;
}

.wrapper .video-controls{
  padding: 5px 20px 10px;
}

.video-controls .options{
  width: 100%;
}

.video-controls .options:first-child{
  justify-content: flex-start;
}

.video-controls .options:last-child{
  justify-content: flex-end;
}

.options button{
  height: 40px;
  width: 40px;
  font-size: 19px;
  border: none;
  cursor: pointer;
  background: none;
  color: #efefef;
  border-radius: 3px;
  transition: all 0.3s ease;
}

.options button :where(i, span) {
  height: 100%;
  width: 100%;
  line-height: 40px;
}

.options button:hover :where(i, span){
  color: $hover-orange;
}

.options button:active :where(i, span){
  transform: scale(1.1);
}

.options button span{
  font-size: 23px;
}

.options input{
  height: 4px;
  margin-left: 3px;
  max-width: 75px;
  accent-color: $bloody-red;
}

.options .video-timer{
  color: #efefef;
  margin-left: 15px;
  font-size: 14px;
}

.video-timer .separator{
  margin: 0 5px;
  font-size: 16px;
  font-family: "Open sans";
}

.playback-content{
  display: flex;
  position: relative;
}
.playback-content .speed-options{
  position: absolute;
  list-style: none;
  left: -40px;
  bottom: 40px;
  width: 95px;
  overflow: hidden;
  opacity: 0;
  border-radius: 4px;
  pointer-events: none;
  background: rgba(255, 255, 255, 0.9);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
  transition: opacity 0.13s ease;
}
.playback-content .speed-options.show{
  opacity: 1;
  pointer-events: auto;
}

.video-container video{
  width: 100%;
}

@media screen and (max-width: 540px) {
  .wrapper .video-controls{
    padding: 3px 10px 7px;
  }

  .options input, .progress-area span{
    display: none!important;
  }
  .options button{
    height: 30px;
    width: 30px;
    font-size: 17px;
  }
  .options .video-timer{
    margin-left: 5px;
  }

  .video-timer .separator{
    font-size: 14px;
    margin: 0 2px;
  }

  .options button :where(i, span) {
    line-height: 30px;
  }

  .options button span{
    font-size: 21px;
  }

  .options .video-timer, .progress-area span {
    font-size: 12px;
  }
}
</style>