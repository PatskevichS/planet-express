<template>
  <div class="MainMenu">
    <div class="main">MENU</div>
  </div>
</template>

<script>
export default {
  name: 'MainMenu'
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.MainMenu {
    padding: 10px;
}

.main {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 350px;
    width: 250px;
    font-size: 12px;
    color: #229B22;
    background: #1D1D95;
    border-radius: 25px;
}
</style>
