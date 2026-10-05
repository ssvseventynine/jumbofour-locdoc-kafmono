<template>
  <div id="app-container">
    <header class="app-header">
      <h1>Artifact: jumbofour-locdoc-kafmono</h1>
    </header>
    <main class="app-content">
      <Dashboard />
    </main>
  </div>
</template>

<script>
import Dashboard from './components/Dashboard.vue';

export default {
  name: 'App',
  components: {
    Dashboard
  }
};
</script>

<style>
/* Global styles for the app */
body {
  margin: 0;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  background-color: #f0f2f5;
  color: #2c3e50;
}
#app-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
.app-header {
  background-color: #1e293b;
  color: white;
  padding: 15px 30px;
  text-align: left;
}
.app-header h1 {
  margin: 0;
  font-size: 20px;
  letter-spacing: 0.5px;
}
.app-content {
  padding: 40px max(20px, 10%);
  flex: 1;
}
/* Reusable component card styles used in child views */
.component-card {
  background: #ffffff;
  padding: 20px;
  border-radius: 6px;
  box-shadow: 0 2px 5px rgba(0,0,0,0.02);
  margin-bottom: 20px;
}
.component-card h3 {
  margin-top: 0;
  margin-bottom: 5px;
  color: #2c3e50;
}
.subtitle {
  margin: 0 0 15px 0;
  font-size: 13px;
  color: #666;
}
</style>