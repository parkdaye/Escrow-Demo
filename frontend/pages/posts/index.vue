<template lang="pug">
  .page-posts.container
    h1.page-title Posts
    p 포스트 목록이 표시되는 페이지입니다.
    PostList(:posts="loadedPosts")
</template>

<script>
import PostList from '@/components/posts/PostList'

export default {
  components: { PostList },
  computed: {
    loadedPosts() {
      return this.$store.getters.loadedPosts
    }
  }
}
</script>

<style lang="sass" scoped>
.page-title
  margin-bottom: 0
  font-family: Changa, Sans-Serif
  letter-spacing: -0.03em

p
  margin-top: 0
  color: rgba(#000, 0.5)
  font-size: 13px
  letter-spacing: -0.06em
</style>