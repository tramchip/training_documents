import streamlit as st
from prompt import create_form
import streamlit.components.v1 as components

from langchain.pydantic_v1 import BaseModel, Field
from langchain.tools import BaseTool, StructuredTool, tool

def run_generated_code(generated_html):
    components.html(generated_html,width=900, height=1100)

# Sidebar
st.sidebar.title('Form Creator',anchor='Apress')
with st.sidebar:
    # st.chat_message("assistant"):
    st.write("Hi there! what form would you like me to create' 👋")
    form_type = st.selectbox(
        'Which type of form you want to create...',
        ['<Click Me to Expand>',
        'Classroom Survey',
        'Student Survey',
        'Class Schedule survey']
    )
    if form_type:
        audience = st.text_input('Audience')
        personal_details = st.text_area('Personal details to collect (comma-separated)').split(',')
        form_theme = st.text_area('Enter your form theme such as style guide to create a form:')
        create_button = st.button('Create Form')


if create_button:
    with st.container():
        form_html = create_form(
            form_type, 
            audience, 
            [detail.strip() for detail in personal_details if detail],
            form_theme,
            allow_file_upload, 
            allow_image_upload,
            
            
        )
        st.code(form_html, language='html')
        run_generated_code(form_html)
    
    
