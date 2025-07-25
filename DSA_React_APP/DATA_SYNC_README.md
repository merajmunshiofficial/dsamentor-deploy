# JSON Data Sync & Deployment Guide

## Overview
This project now has an automated system to sync JSON data files from `src/data/` to `dist/data/` and ensure they're tracked in Git for deployment.

## How It Works

### 1. Automatic Sync During Deployment
When you run `npm run deploy`, the system will:
1. Build the project (`npm run build`)
2. Sync all JSON files from `src/data/` to `dist/data/` (`npm run sync-data`)
3. Add the `dist/data/` files to Git tracking (overriding .gitignore)
4. Deploy to GitHub Pages

### 2. Manual Sync (When Needed)
If you update JSON files and want to sync them immediately:
```bash
npm run sync-data
```

## Workflow for Updating JSON Files

### Option 1: Update in src/data/ (Recommended)
1. Edit your JSON files in `src/data/[topic]/problems.json`
2. Run `npm run deploy` - this will automatically sync and deploy

### Option 2: Update in dist/data/ (Quick Updates)
1. Edit JSON files directly in `dist/data/[topic]/problems.json`
2. Run `npm run sync-data` to ensure Git tracking
3. Commit and push changes:
   ```bash
   git add dist/data/ -f
   git commit -m "Update JSON data files"
   git push
   ```
4. Run `npm run deploy` to deploy

## Key Benefits
- ✅ JSON files in `dist/data/` are always tracked by Git
- ✅ Automatic sync during deployment
- ✅ No risk of losing JSON updates during build process
- ✅ Can update JSON files anytime and deploy easily

## Scripts Added
- `npm run sync-data` - Syncs JSON files from src to dist and adds to Git
- Modified `predeploy` - Now runs build + sync-data before deployment

## Files Added
- `sync-data.js` - Node.js script that handles the syncing process
- `DATA_SYNC_README.md` - This documentation file

## Important Notes
- The `dist/` folder is in `.gitignore`, but we force-add `dist/data/` files
- Always run `npm run deploy` for full deployment (includes sync)
- The sync script preserves the directory structure from `src/data/`
