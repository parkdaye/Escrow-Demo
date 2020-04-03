<template lang="pug">
section.post-list
  PostPreview(
    v-for="post in posts",
    :key="post.id",
    :id="post.id",
    :isMypage="isMypage",
    :title="post.title",
    :thumbnail="post.thumbnail",
    :content="post.content"
  )
</template>

<script>
import PostPreview from '@/components/posts/PostPreview'

export default {
  components: { PostPreview },
  props: {
    isMypage: {
      type: Boolean,
      default: false
    },
    posts: {
      type: Array,
      required: true
    }
  }
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