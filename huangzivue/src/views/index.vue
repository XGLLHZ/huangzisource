<template>
  <div>
    <homenav></homenav>
    <homemain1></homemain1>
    <homefooter></homefooter>
  </div>
</template>

<script>
import homenav from '@/components/homenav'
import homemain1 from '@/components/homemain1'
import homefooter from '@/components/homefooter'
export default {
  name: 'index',
  components: {
    homenav,
    homemain1,
    homefooter
  }
}
</script>

<style>
  
</style>
