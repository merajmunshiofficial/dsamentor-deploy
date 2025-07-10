# GitHub Repository Secrets Setup Guide

## 🔐 Setting Up Repository Secrets for Auth0

This guide will help you set up GitHub repository secrets to securely store your Auth0 credentials for automatic deployment.

## 📝 Step-by-Step Instructions

### 1. Access Repository Settings
1. Go to your private repository: https://github.com/merajmunshiofficial/DSA_React_APP
2. Click on **Settings** tab
3. In the left sidebar, click on **Secrets and variables**
4. Click on **Actions**

### 2. Add Repository Secrets
Click **New repository secret** for each of the following:

#### Secret 1: VITE_AUTH0_DOMAIN
- **Name**: `VITE_AUTH0_DOMAIN`
- **Value**: `merajmunshi.us.auth0.com`

#### Secret 2: VITE_AUTH0_CLIENT_ID
- **Name**: `VITE_AUTH0_CLIENT_ID`
- **Value**: `wetVbccRWFxGMtiWEfAI9XGFZnWRj4Gd`

#### Secret 3: VITE_AUTH0_AUDIENCE (Optional)
- **Name**: `VITE_AUTH0_AUDIENCE`
- **Value**: Leave empty or add your Auth0 API audience if you have one

### 3. Repository Access Token (Already Set)
The `GITHUB_TOKEN` is automatically provided by GitHub Actions and has the necessary permissions.

## 🚀 How It Works

1. **When you push code** to the main branch of your private repository
2. **GitHub Actions** automatically runs the workflow
3. **Creates .env file** using the repository secrets
4. **Builds the app** with your Auth0 credentials
5. **Deploys to public repository** (dsamentor-deploy)

## ✅ Benefits of Using Repository Secrets

- 🔒 **Security**: Credentials are encrypted and not visible in code
- 🔄 **Automatic**: Deploys happen automatically on push
- 🚀 **Convenience**: No manual deployment needed
- 🎯 **Production-ready**: Proper CI/CD pipeline

## 📋 Current Workflow

```yaml
name: Deploy to GitHub Pages

on:
  push:
    branches: [ main ]

jobs:
  build-and-deploy:
    runs-on: ubuntu-latest
    steps:
    - name: Checkout
      uses: actions/checkout@v4
      
    - name: Setup Node.js
      uses: actions/setup-node@v4
      with:
        node-version: '18'
        cache: 'npm'
        
    - name: Install dependencies
      run: npm ci

    - name: Create .env file from secrets
      run: |
        echo "VITE_AUTH0_DOMAIN=${{ secrets.VITE_AUTH0_DOMAIN }}" > .env
        echo "VITE_AUTH0_CLIENT_ID=${{ secrets.VITE_AUTH0_CLIENT_ID }}" >> .env
        echo "VITE_AUTH0_AUDIENCE=${{ secrets.VITE_AUTH0_AUDIENCE }}" >> .env
      
    - name: Build
      run: npm run build
      
    - name: Deploy to GitHub Pages
      uses: peaceiris/actions-gh-pages@v3
      if: github.ref == 'refs/heads/main'
      with:
        github_token: ${{ secrets.GITHUB_TOKEN }}
        publish_dir: ./dist
        external_repository: merajmunshiofficial/dsamentor-deploy
        publish_branch: main
        force_orphan: true
```

## 🔧 Testing the Setup

After adding the secrets:
1. Make any small change to your code
2. Commit and push to the main branch
3. Check the **Actions** tab in your repository
4. Watch the workflow run automatically
5. Your app will be deployed to: https://merajmunshiofficial.github.io/dsamentor-deploy/

## 🎉 Final Result

Once set up, every time you push code to your private repository, it will:
- ✅ Build with your Auth0 credentials
- ✅ Deploy to your public GitHub Pages
- ✅ Keep your source code private
- ✅ Make your app accessible to users

No more manual deployment needed! 🚀
