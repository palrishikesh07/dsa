const fs = require('fs');
const path = require('path');

function removeMatchingPattern(dir, pattern) {
  fs.readdirSync(dir).forEach(file => {
    const fullPath = path.join(dir, file);
    if (fs.statSync(fullPath).isDirectory()) {
      removeMatchingPattern(fullPath, pattern); // Recurse
    } else if (pattern.test(file)) {
      fs.unlinkSync(fullPath); // Delete match
    }
  });
}

// Usage: Remove all .class files
removeMatchingPattern('./pattern', /\.class$/);   