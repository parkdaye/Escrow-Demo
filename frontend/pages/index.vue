<template lang="pug">
.page-home
  PostList(:posts="loadedPosts")
            
  //- <div class="container">
  //-   <div>
  //-     <h1>홈페이지</h1>
  //-     <!-- <h2 class="subtitle">
  //-       escrow-demo-frontend
  //-     </h2>
  //-     <nuxt-link v-for="post in posts"
  //-     :key="post.title"
  //-     :to="{name: 'posts-post', params:{title:post.title, content:post.content}}"
  //-     class="button--grey">
  //-     {{post.title}}
  //-     </nuxt-link> -->
  //-   </div>
  //- </div>
</template>

<script>
import PostList from '@/components/posts/PostList'
import axios from "axios";
import { async } from "q";

export default {
  components: {
    PostList
  },
  computed: {
    loadedPosts() {
      return this.$store.getters.loadedPosts
    }
  }
  // async asyncData() {
  //   let { data } = await axios.get("http://localhost:8080/posts");
  //   return { posts: data };
  // }
};
</script>

<style lang="sass" scoped>
@import "~assets/styles/config"

a
  text-decoration: none
  color: darken($color, 20%)
  transition: all 0.4s ease
  &:hover .post-content,
  &:active .post-content
    background-color: rgba($color, 0.26)

@media (min-width: 768px)
  .intro h1
    font-size: 2rem
</style>
