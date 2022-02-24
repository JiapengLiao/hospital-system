<template>
  <!-- <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </div> -->
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<style>
html{
  height: 100%;
}
body{
  margin: 0;
  padding: 0;
  height: 100%;
}
#app{
  height: 100%;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
