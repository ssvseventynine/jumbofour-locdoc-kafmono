<template>
  <div class="component-card form-container">
    <h3>1. LocDoc Kafka Producer Tier</h3>
    <p class="subtitle">Submit messages directly to the Spring Boot REST endpoint, which forwards them to the Kafka cluster.</p>
    
    <div class="input-group">
      <input 
        v-model="messageContent" 
        placeholder="Type a message to send to Kafka..." 
        @keyup.enter="sendMessage"
      />
      <button @click="sendMessage" :disabled="!messageContent.trim()">
        Publish to Topic
      </button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'MessageForm',
  data() {
    return {
      messageContent: ''
    };
  },
  methods: {
    async sendMessage() {
      if (!this.messageContent.trim()) return;

      try {
        // Post the raw data to our Spring Boot backend
        await axios.post('http://localhost:8080/api/messages', {
          content: this.messageContent
        });
        
        // Clear input field on success
        this.messageContent = '';
      } catch (error) {
        console.error("Error sending message to backend:", error);
        alert("Failed to send message. Make sure Spring Boot is running.");
      }
    }
  }
};
</script>

<style scoped>
.form-container {
  border-left: 4px solid #42b983;
}
.input-group {
  display: flex;
  gap: 10px;
  margin-top: 15px;
}
input {
  flex: 1;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
}
button {
  padding: 10px 20px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: bold;
}
button:disabled {
  background-color: #cccccc;
  cursor: not-allowed;
}
</style>