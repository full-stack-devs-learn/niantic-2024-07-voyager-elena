const createElement = (elemType, classNames, textContent) => {
  const elem = document.createElement(elemType);
  if (classNames) {
    Array.isArray(classNames)
      ? elem.classList.add(...classNames)
      : elem.classList.add(classNames);
  }
  if (textContent) {
    elem.textContent = textContent;
  }
  return elem;
};