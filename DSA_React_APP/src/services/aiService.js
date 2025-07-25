// AI Service - Unified interface for OpenAI and Perplexity APIs
class AIService {
  constructor() {
    this.providers = {
      openai: {
        name: 'OpenAI',
        endpoint: 'https://api.openai.com/v1/chat/completions',
        model: 'gpt-3.5-turbo',
        keyPrefix: 'sk-',
        storageKey: 'openai_api_key'
      },
      perplexity: {
        name: 'Perplexity',
        endpoint: 'https://api.perplexity.ai/chat/completions',
        model: 'sonar',
        keyPrefix: 'pplx-',
        storageKey: 'perplexity_api_key'
      }
    };
  }

  // Get current provider preference
  getCurrentProvider() {
    return localStorage.getItem('ai_provider_preference') || 'openai';
  }

  // Set provider preference
  setCurrentProvider(provider) {
    if (this.providers[provider]) {
      localStorage.setItem('ai_provider_preference', provider);
      return true;
    }
    return false;
  }

  // Get API key for specific provider
  getApiKey(provider = null) {
    const currentProvider = provider || this.getCurrentProvider();
    const providerConfig = this.providers[currentProvider];
    if (!providerConfig) return null;
    
    return localStorage.getItem(providerConfig.storageKey);
  }

  // Set API key for specific provider
  setApiKey(provider, apiKey) {
    const providerConfig = this.providers[provider];
    if (!providerConfig) return false;
    
    if (apiKey && apiKey.trim()) {
      localStorage.setItem(providerConfig.storageKey, apiKey.trim());
      return true;
    }
    return false;
  }

  // Remove API key for specific provider
  removeApiKey(provider) {
    const providerConfig = this.providers[provider];
    if (!providerConfig) return false;
    
    localStorage.removeItem(providerConfig.storageKey);
    return true;
  }

  // Validate API key format
  validateApiKey(provider, apiKey) {
    const providerConfig = this.providers[provider];
    if (!providerConfig || !apiKey) return false;
    
    return apiKey.trim().startsWith(providerConfig.keyPrefix);
  }

  // Get available providers with their status
  getProvidersStatus() {
    const status = {};
    Object.keys(this.providers).forEach(provider => {
      const apiKey = this.getApiKey(provider);
      status[provider] = {
        ...this.providers[provider],
        hasKey: !!apiKey,
        isValid: apiKey ? this.validateApiKey(provider, apiKey) : false
      };
    });
    return status;
  }

  // Test API connection
  async testConnection(provider, apiKey = null) {
    const providerConfig = this.providers[provider];
    if (!providerConfig) {
      throw new Error('Invalid provider');
    }

    const key = apiKey || this.getApiKey(provider);
    if (!key) {
      throw new Error('No API key provided');
    }

    try {
      const response = await fetch(providerConfig.endpoint, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${key}`
        },
        body: JSON.stringify({
          model: providerConfig.model,
          messages: [
            { role: 'user', content: 'Hello, this is a test message.' }
          ],
          max_tokens: 10
        })
      });

      if (!response.ok) {
        const errorData = await response.json().catch(() => ({}));
        throw new Error(errorData.error?.message || `HTTP ${response.status}`);
      }

      return { success: true, provider: providerConfig.name };
    } catch (error) {
      throw new Error(`Connection test failed: ${error.message}`);
    }
  }

  // Main method to get AI feedback
  async getCodeFeedback(userCode, referenceCode, provider = null) {
    const currentProvider = provider || this.getCurrentProvider();
    const providerConfig = this.providers[currentProvider];
    const apiKey = this.getApiKey(currentProvider);

    if (!providerConfig) {
      throw new Error('Invalid AI provider selected');
    }

    if (!apiKey) {
      throw new Error(`No ${providerConfig.name} API key found. Please add your API key in settings.`);
    }

    const prompt = `You are a DSA coding mentor. Compare the user's code to the reference solution.

Reference Solution:
${referenceCode}

User's Code:
${userCode}

If the user's code is correct, reply with 'Correct' and a brief explanation. If incorrect, explain what is wrong, how to fix it, and provide actionable guidance.`;

    try {
      const response = await fetch(providerConfig.endpoint, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${apiKey}`
        },
        body: JSON.stringify({
          model: providerConfig.model,
          messages: [
            { 
              role: 'system', 
              content: 'You are a helpful DSA coding mentor. Provide detailed and in-depth explanations.' 
            },
            { role: 'user', content: prompt }
          ],
          max_tokens: 1024,
          temperature: 0.7
        })
      });

      if (!response.ok) {
        const errorData = await response.json().catch(() => ({}));
        throw new Error(`${providerConfig.name} API error: ${errorData.error?.message || response.status}`);
      }

      const data = await response.json();
      const feedback = data.choices?.[0]?.message?.content || 'No feedback received.';
      
      return {
        feedback,
        provider: providerConfig.name,
        model: providerConfig.model
      };
    } catch (error) {
      // If current provider fails, try fallback (if available)
      if (!provider && currentProvider === 'openai') {
        const perplexityKey = this.getApiKey('perplexity');
        if (perplexityKey) {
          console.warn('OpenAI failed, trying Perplexity fallback:', error.message);
          return this.getCodeFeedback(userCode, referenceCode, 'perplexity');
        }
      } else if (!provider && currentProvider === 'perplexity') {
        const openaiKey = this.getApiKey('openai');
        if (openaiKey) {
          console.warn('Perplexity failed, trying OpenAI fallback:', error.message);
          return this.getCodeFeedback(userCode, referenceCode, 'openai');
        }
      }
      
      throw error;
    }
  }

  // Migration helper for existing OpenAI keys
  migrateExistingKeys() {
    const existingKey = localStorage.getItem('openai_api_key');
    if (existingKey && !localStorage.getItem('ai_provider_preference')) {
      // Set default provider to OpenAI for existing users
      this.setCurrentProvider('openai');
      console.log('Migrated existing OpenAI API key');
    }
  }
}

// Export singleton instance
export default new AIService();
