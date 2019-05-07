<template>
  <div id="app">
     <Header/>
     <div class="layout">
        <MainMenu/>
        <Display/>
     </div>
  </div>
</template>

<script>
import Header from "./components/Header";
import MainMenu from "./components/MainMenu";
import Display from "./components/Display";

export default {
  name: 'app',
  components: {
    Header,
    MainMenu,
    Display
  }
}
</script>

<style>
#app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
            text-align: center;
            color: #2c3e50;
    overflow-x: hidden;
}

.layout{
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 70px;
}
</style>
