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
removeMatchingPattern('./', /\.class$/);  



function countFilesByExtension(dir, extension) {
  let count = 0;

  // Ensure extension starts with "."
  if (!extension.startsWith('.')) {
    extension = '.' + extension;
  }

  function traverse(currentDir) {
    const files = fs.readdirSync(currentDir);

    for (const file of files) {
      const fullPath = path.join(currentDir, file);

      if (fs.statSync(fullPath).isDirectory()) {
        traverse(fullPath); // Recurse into subfolder
      } else if (path.extname(file) === extension) {
        count++;
      }
    }
  }

  traverse(dir);
  return count;
}


const totalClassFiles = countFilesByExtension('java', 'java');
console.log(`Total .java files: ${totalClassFiles}`);
