#!/bin/bash
# Manual deployment script for GitHub Pages

echo "Building the project..."
npm run build

echo "Deploying to GitHub Pages..."
npm run deploy

echo "Deployment complete! Your site should be available at:"
echo "https://yourusername.github.io/your-repo-name"
