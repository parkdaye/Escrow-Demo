<template lang="pug">
  .page-posts.container
    h1.page-title Posts
    p 포스트 목록이 표시되는 페이지입니다.
    PostList(:posts="loadedPosts")
</template>

<script>
import PostList from '@/components/posts/PostList'

export default {
  asyncData(context) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve({
          loadedPosts: [
            {
              id: "1",
              title: "테스트 포스트1",
              thumbnail: "//goo.gl/mJ5Vsy",
              content: "테스트랍니다 헤헿 새벽 세시 졸리다 헿헤"
            },
            {
              id: "2",
              title: "테스트 포스트2",
              thumbnail: "//goo.gl/mJ5Vsy",
              content: "테스트랍니다 헤헿 새벽 세시 졸리다 헿헤"
            }
          ]
        })
      }, 1000) 
    })
      .then(data => data)
      .catch(e => context.error(e))
  },
  components: { PostList }
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