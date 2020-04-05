import Vuex from 'vuex'
import axios from 'axios'

// 스토어 생성 함수 정의
const createStore = () => {
  // Vuex.Store 객체 생성 반환
  return new Vuex.Store({
    // 상태(데이터)
    state: { loadedPosts: [] },
    // 쓰기(동기 처리)
    mutations: {
      setPosts(state, posts) {
        state.loadedPosts = posts
      },
      createPost(state, createdPost) {
        state.loadedPosts.push(createdPost)
      },
      updatePost(state, updatedPost) {
        const idx = state.loadedPosts.findIndex(
          post => post.id === updatedPost.id
        )
        state.loadedPosts[idx] = updatedPost
      }
    },
    // 액션(비동기 처리 ⟹ 쓰기 커밋)
    actions: {
      async nuxtServerInit({ commit }, context) {
        try {
          const { data } = await axios.get('https://localhost:8080/posts')
          const postsList = []
          for (let key in data) {
            postsList.push({ ...data[key], id: key })
          }
          console.log(postsList)
          commit('setPosts', postsList)
        } catch (e) {
          console.error(e)
        }
      },
      setPosts({ commit }, posts) {
        commit('setPosts', posts)
      },
      createPost({ commit }, createdPost) {
        //createdPost.createdDate = new Date().toLocaleString()
        return axios
          .post('http://localhost:8080/posts', createdPost)
          .then(res => {
            // 통신이 성공하면 뮤테이션에 커밋
            commit('createPost', { ...createdPost, id: res.data.name })
          })
          .catch(e => console.error(e))
      },
      updatePost({ commit }, updatedPost) {
        updatedPost.updatedDate = new Date().toLocaleString()
        return axios
          .put(
            'https://localhost:8080/posts/${updatedPost.id}',
            updatedPost
          )
          .then(res => {
            commit('updatePost', updatedPost)
          })
          .catch(e => console.error(e))
      }
    },
    // 읽기
    getters: {
      loadedPosts(state) {
        return state.loadedPosts
      }
    }
  })
}

// createStore 함수 모듈 기본으로 내보내기
export default createStore