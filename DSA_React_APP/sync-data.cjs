#!/usr/bin/env node

const fs = require('fs');
const path = require('path');
const { execSync } = require('child_process');

// Function to copy directory recursively
function copyDir(src, dest) {
  if (!fs.existsSync(dest)) {
    fs.mkdirSync(dest, { recursive: true });
  }
  
  const entries = fs.readdirSync(src, { withFileTypes: true });
  
  for (let entry of entries) {
    const srcPath = path.join(src, entry.name);
    const destPath = path.join(dest, entry.name);
    
    if (entry.isDirectory()) {
      copyDir(srcPath, destPath);
    } else {
      fs.copyFileSync(srcPath, destPath);
      console.log(`Copied: ${srcPath} -> ${destPath}`);
    }
  }
}

// Main function
function syncData() {
  console.log('🔄 Syncing JSON data files...');
  
  // Copy all data from src/data to dist/data
  const srcDataDir = path.join(__dirname, 'src', 'data');
  const distDataDir = path.join(__dirname, 'dist', 'data');
  
  if (fs.existsSync(srcDataDir)) {
    copyDir(srcDataDir, distDataDir);
    console.log('✅ Data files synced successfully!');
    
    // Add dist/data to git tracking (force add to override .gitignore)
    try {
      execSync('git add dist/data/ -f', { stdio: 'inherit' });
      console.log('✅ Added dist/data files to Git tracking');
    } catch (error) {
      console.log('⚠️  Could not add to Git (this is normal if no changes)');
    }
  } else {
    console.log('❌ Source data directory not found!');
  }
}

// Run the sync
syncData();
