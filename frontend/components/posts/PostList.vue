<template lang="pug">
section.post-list
  PostPreview(
    id="1",
    title="테스트 포스트1",
    thumbnail="//goo.gl/mJ5Vsy",
    content="테스트랍니다 헤헿 새벽 세시 졸리다 헿헤"
  )
  PostPreview(
    id="2",
    title="테스트 포스트2",
    thumbnail="//goo.gl/mJ5Vsy",
    content="테스트랍니다 헤헿 새벽 세시 졸리다 헿헤"
  )
</template>

<script>
import PostPreview from '@/components/posts/PostPreview'

export default {
  components: { PostPreview }
}
</script>

<style lang="sass" scoped>
.post-list
  display: flex
  justify-content: center
  align-items: flex-start
  flex-wrap: wrap
  padding: 20px
</style>