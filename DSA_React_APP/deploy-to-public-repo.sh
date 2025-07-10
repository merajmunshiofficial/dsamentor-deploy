#!/bin/bash
# Deploy to Separate Public Repository
# This script builds your app and pushes only the dist folder to a public repo

echo "🚀 Building and deploying DSA Mentor..."

# Step 1: Build the application
echo "📦 Building application..."
npm run build

if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    
    # Step 2: Navigate to dist folder
    cd dist
    
    # Step 3: Initialize git in dist folder (if not already)
    if [ ! -d ".git" ]; then
        echo "🔧 Initializing git in dist folder..."
        git init
        git branch -M main
    fi
    
    # Step 4: Add all files
    echo "📁 Adding files..."
    git add .
    
    # Step 5: Commit changes
    timestamp=$(date '+%Y-%m-%d %H:%M:%S')
    git commit -m "Deploy DSA Mentor - $timestamp"
    
    # Step 6: Push to public deployment repository
    echo "🚀 Deploying to public repository..."
    
    # Add remote if not exists
    if ! git remote get-url origin > /dev/null 2>&1; then
        git remote add origin https://github.com/merajmunshiofficial/dsamentor-deploy.git
    fi
    
    # Push to main branch
    git push -u origin main --force
    
    if [ $? -eq 0 ]; then
        echo "🎉 Deployment successful!"
        echo "Your app will be available at:"
        echo "https://merajmunshiofficial.github.io/dsamentor-deploy/"
    else
        echo "❌ Deployment failed!"
    fi
    
    # Return to original directory
    cd ..
else
    echo "❌ Build failed!"
fi
