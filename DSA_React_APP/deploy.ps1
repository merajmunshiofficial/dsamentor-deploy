# PowerShell deployment script for GitHub Pages

Write-Host "Building the project..." -ForegroundColor Green
npm run build

if ($LASTEXITCODE -eq 0) {
    Write-Host "Deploying to GitHub Pages..." -ForegroundColor Green
    npm run deploy
    
    if ($LASTEXITCODE -eq 0) {
        Write-Host "Deployment complete! Your site should be available at:" -ForegroundColor Green
        Write-Host "https://yourusername.github.io/your-repo-name" -ForegroundColor Cyan
    } else {
        Write-Host "Deployment failed!" -ForegroundColor Red
    }
} else {
    Write-Host "Build failed!" -ForegroundColor Red
}
