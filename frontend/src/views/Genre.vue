<template>
  <div class="container">
    <div class="row">
      <div class="col-md-4 mt-5">
        <div class="list-group">
          <genre-component></genre-component>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import GenreComponent from '@/components/GenreComponent.vue'

export default {
  name: 'Genre',
  components: {
    GenreComponent
  }
}
</script>
