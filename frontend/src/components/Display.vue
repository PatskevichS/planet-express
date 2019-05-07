<template>
  <div class="Display">
    <div class="main">DISPLAY</div>
  </div>
</template>

<script>
export default {
  name: 'Display'
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.Display {
    padding: 10px;
}
.main{
    display: flex;
    justify-content: center;
    align-items: center;
    height: 350px;
    width: 650px;
    font-size: 12px;
    color: #229B22;
    background: #1D1D95;
    border-radius: 25px;
}
</style>
