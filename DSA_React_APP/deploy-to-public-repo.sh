#!/bin/bash
# Deploy to Separate Public Repository
# This script builds your app and pushes only the dist folder to a public repo

echo "🚀 Building and deploying DSA Mentor..."

# Step 1: Check for environment variables
echo "🔍 Checking environment variables..."
if [ ! -f ".env" ]; then
    echo "❌ Error: .env file not found! Please create one from .env.example"
    echo "📝 Refer to AUTH0_SETUP_GUIDE.md for configuration instructions"
    exit 1
fi

# Step 2: Build the application
echo "📦 Building application..."
npm run build

if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    
    # Step 3: Navigate to dist folder
    cd dist
    
    # Step 4: Initialize git in dist folder (if not already)
    if [ ! -d ".git" ]; then
        echo "🔧 Initializing git in dist folder..."
        git init
        git branch -M main
    fi
    
    # Step 5: Clean sensitive data from build files
    echo "🧹 Cleaning sensitive data from build files..."
    find . -type f -name "*.js" -exec sed -i \
        -e 's/sk-[a-zA-Z0-9]\{32,\}/sk-REMOVED/g' \
        -e 's/sk-proj-[a-zA-Z0-9-]\{32,\}/sk-proj-REMOVED/g' \
        -e 's/auth0\.com/auth0.com/g' \
        -e 's/[a-zA-Z0-9]\{32,\}/CLIENT-ID-REMOVED/g' {} +
    
    # Step 6: Add all files
    echo "📁 Adding files..."
    git add .
    
    # Step 7: Commit changes
    timestamp=$(date '+%Y-%m-%d %H:%M:%S')
    git commit -m "Deploy DSA Mentor - $timestamp"
    
    # Step 8: Push to public deployment repository
    echo "🚀 Deploying to public repository..."
    
    # Add remote if not exists
    if ! git remote get-url origin > /dev/null 2>&1; then
        git remote add origin https://github.com/merajmunshiofficial/dsamentorai.git
    fi
    
    # Push to main branch
    git push -u origin main --force
    
    if [ $? -eq 0 ]; then
        echo "🎉 Deployment successful!"
        echo "Your app will be available at:"
        echo "https://merajmunshiofficial.github.io/dsamentorai/"
    else
        echo "❌ Deployment failed!"
    fi
    
    # Return to original directory
    cd ..
else
    echo "❌ Build failed!"
fi
