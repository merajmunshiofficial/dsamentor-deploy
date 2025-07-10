# Deploy to Separate Public Repository
# This script builds your app and pushes only the dist folder to a public repo

Write-Host "Building and deploying DSA Mentor..." -ForegroundColor Green

# Step 1: Build the application
Write-Host "Building application..." -ForegroundColor Yellow
npm run build

if ($LASTEXITCODE -eq 0) {
    Write-Host "Build successful!" -ForegroundColor Green
    
    # Step 2: Navigate to dist folder
    Push-Location dist
    
    # Step 3: Initialize git in dist folder (if not already)
    if (-not (Test-Path ".git")) {
        Write-Host "Initializing git in dist folder..." -ForegroundColor Yellow
        git init
        git branch -M main
    }
    
    # Step 4: Add all files
    Write-Host "Adding files..." -ForegroundColor Yellow
    git add .
    
    # Step 5: Commit changes
    $timestamp = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
    git commit -m "Deploy DSA Mentor - $timestamp"
    
    # Step 6: Push to public deployment repository
    Write-Host "Deploying to public repository..." -ForegroundColor Yellow
    
    # Add remote if not exists
    $remoteExists = git remote get-url origin 2>$null
    if (-not $remoteExists) {
        git remote add origin https://github.com/merajmunshiofficial/dsamentor-deploy.git
    }
    
    # Push to main branch
    git push -u origin main --force
    
    if ($LASTEXITCODE -eq 0) {
        Write-Host "Deployment successful!" -ForegroundColor Green
        Write-Host "Your app will be available at:" -ForegroundColor Cyan
        Write-Host "https://merajmunshiofficial.github.io/dsamentor-deploy/" -ForegroundColor Cyan
    } else {
        Write-Host "Deployment failed!" -ForegroundColor Red
    }
    
    # Return to original directory
    Pop-Location
} else {
    Write-Host "Build failed!" -ForegroundColor Red
}

Write-Host "Done!" -ForegroundColor Green