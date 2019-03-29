<!--App.vue相当于父组件，来展示<router-view>中的内容，其内容来自于肉router中的路由所指向的组件-->
<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
}
</style>
