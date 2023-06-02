<template>
  <form>
    <input type="text" placeholder="Пошук" name="search">
  </form>
</template>

<script>
export default {
  name: "SearchBar"
}
</script>

<style scoped>
input[type=text] {
  padding: 6px;
  margin: 8px 0;
  border: none;
  width: 30%;
}
</style>