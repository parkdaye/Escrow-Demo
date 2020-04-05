<template lang="pug">
.page-mypage-post.container
  section.update-form
    h2.page-title 포스트 수정
    p 작성된 글을 수정합니다.
    PostForm(:post="loadedPost", @submit="onSubmitted")
</template>

<script>
import PostForm from '@/components/posts/PostForm'
import axios from 'axios'

export default {
  components: { PostForm },
  computed: {
    loadedPost() {
      const id = this.$route.params.postId
      return this.$store.getters.loadedPosts.find(
        post => post.title.replace(/\?/, '') === id
      )
    }
  },
  methods: {
    onSubmitted(editedPost) {
      this.$store
        .dispatch('updatePost', editedPost)
        .then(res => this.$router.push('/mypage'))
    }
  }
}
</script>